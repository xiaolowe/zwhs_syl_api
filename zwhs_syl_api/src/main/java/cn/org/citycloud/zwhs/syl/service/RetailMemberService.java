package cn.org.citycloud.zwhs.syl.service;

import cn.org.citycloud.zwhs.syl.bean.RetailMemberBean;
import cn.org.citycloud.zwhs.syl.bean.RetailMemberSearch;
import cn.org.citycloud.zwhs.syl.bean.RetailShopBean;
import cn.org.citycloud.zwhs.syl.bean.RetailShopSearch;
import cn.org.citycloud.zwhs.syl.constants.Constants;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.*;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2016/7/26 10:37
 */
@Service
public class RetailMemberService {
    @Autowired
    private RetailMemberDao retailMemberDao;

    @Autowired
    private RetailShopDao retailShopDao;

    @Autowired
    private RetailShopGoodsDao shopGoodsDao;

    @Autowired
    private WechatMemberDao wechatMemberDao;

    @Autowired
    private StoreGoodDao storeGoodDao;

    /**
     * 查询分销会员列表
     *
     * @param retailMemberSearch 查询bean
     * @return
     */
    public Object findPage(RetailMemberSearch retailMemberSearch) {
        Sort sort = new Sort(Sort.Direction.DESC, "memberId");
        Pageable pageable = new PageRequest(retailMemberSearch.getPageNo() - 1, retailMemberSearch.getPageSize(), sort);
        Page<RetailMember> page = retailMemberDao.findAll(new Specification<RetailMember>() {
            @Override
            public Predicate toPredicate(Root<RetailMember> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate where = cb.conjunction();
                if(retailMemberSearch != null && retailMemberSearch.getMemberState() != -1){
                    Path<Integer> memberState = root.get("memberState");
                    where = cb.and(where, cb.equal(memberState, retailMemberSearch.getMemberState()));
                }
                if(retailMemberSearch != null && !StringUtils.isEmpty(retailMemberSearch.getMemberTruename())){
                    Path<String> memberTruename = root.get("memberTruename");
                    where = cb.and(where, cb.like(memberTruename, "%" + retailMemberSearch.getMemberTruename() + "%"));
                }
                if (retailMemberSearch != null && !StringUtils.isEmpty(retailMemberSearch.getMemberId())) {
                    Path<String> memberId = root.get("memberId");
                    where = cb.and(where, cb.like(memberId.as(String.class), "%" + retailMemberSearch.getMemberId() + "%"));
                }
                if(retailMemberSearch != null && !StringUtils.isEmpty(retailMemberSearch.getStartTime()) && !StringUtils.isEmpty(retailMemberSearch.getEndTime())){
                    Path<Date> addTime = root.get("memberTime");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date start = new Date();
                    Date end = new Date();
                    String startTime = retailMemberSearch.getStartTime() + " 00:00:00";
                    String endTime = retailMemberSearch.getEndTime() + " 23:59:59";
                    try {
                        start = sdf.parse(startTime);
                        end = sdf.parse(endTime);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    where = cb.and(where, cb.between(addTime, start, end));

                }
                query.where(where);
                return null;
            }
        }, pageable);
        return page;
    }

    /**
     * 查询分销会员详情
     *
     * @param memberId 分销会员id
     * @return
     */
    public Object findMemberDetail(int memberId) {
        return retailMemberDao.findOne(memberId);
    }

    /**
     * 分销会员审核通过
     *
     *
     * @param memberId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Object passMember(int memberId) {
        RetailMember retailMember = retailMemberDao.findOne(memberId);
        retailMember.setUpdDate(new Date());
        retailMember.setMemberState(Constants.RETAIL_MEMBER_PASSED);
        retailMemberDao.save(retailMember);

        // 审核通过后，将分销会员关联的母婴店下加入分销的商品信息复制到分销商品表中
        Specification<StoreGood> specification = new Specification<StoreGood>() {
            @Override
            public Predicate toPredicate(Root<StoreGood> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate where = cb.conjunction();
                Path<Integer> storeId = root.get("store").get("storeId");
                where = cb.and(where, cb.equal(storeId, retailMember.getStore().getStoreId()));

                Path<Integer> isAddRetail = root.get("isAddRetail");
                where = cb.and(where, cb.equal(isAddRetail, 1));

                Path<Integer> goodsVerify = root.get("goodsVerify");
                where = cb.and(where, cb.equal(goodsVerify, 1));
                query.where(where);
                return null;
            }
        };
        List<StoreGood> goodList = storeGoodDao.findAll(specification);
        for (StoreGood storeGood : goodList) {
            RetailShopGood retailShopGood = new RetailShopGood();
            retailShopGood.setStatus(1);
            retailShopGood.setUpdateTime(new Date());
            retailShopGood.setCreateTime(new Date());
            retailShopGood.setAlreadySale(storeGood.getSellNumber());
            retailShopGood.setGoodsId(storeGood.getGoodsId());
            retailShopGood.setShopGoodsPrice(storeGood.getRetailSalePrice());
            retailShopGood.setMemberId(retailMember.getMemberId());
            retailShopGood.setRetailMemberName(retailMember.getWechatAliasname());
            retailShopGood.setGoodsName(storeGood.getGoodsName());
            retailShopGood.setOnlineTime(new Date());
            retailShopGood.setShopGoodsPrice(storeGood.getRetailSalePrice());
            retailShopGood.setGoodsImage(storeGood.getGoodsImage());
            retailShopGood.setGoodsImageSmall(storeGood.getGoodsImageSmall());
            retailShopGood.setInitPrice(storeGood.getRetailInitPrice());
            retailShopGood.setSalePrice(storeGood.getRetailSalePrice());
            shopGoodsDao.save(retailShopGood);
        }

        // 审核通过后新增一条店铺信息
        RetailShop retailShop = new RetailShop();
        retailShop.setMemberId(memberId);
        retailShop.setUpdDate(new Date());
        retailShop.setInsDate(new Date());
        retailShop.setStatus(1);
        retailShopDao.save(retailShop);
        return retailMember;
    }

    /**
     * 分销会员审核驳回
     *
     * @param memberId
     * @return
     */
    public Object rejectedMember(int memberId) {
        RetailMember retailMember = retailMemberDao.findOne(memberId);
        retailMember.setUpdDate(new Date());
        retailMember.setMemberState(Constants.RETAIL_MEMBER_REJECTED);
        retailMemberDao.save(retailMember);
        return retailMember;
    }

    /**
     * 修改分销会员信息
     *
     * @param bean
     * @param memberId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Object updateMember(RetailMemberBean bean, int memberId) throws BusinessErrorException {
        // 更新分销用户表的信息
        RetailMember retailMember = retailMemberDao.findOne(memberId);
        BeanUtils.copyProperties(bean, retailMember);
        retailMember.setUpdDate(new Date());
        retailMemberDao.save(retailMember);
        // 更新普通用户表的信息
        WechatMember wechatMember = wechatMemberDao.findOne(memberId);
        if (wechatMember == null) {
            throw new BusinessErrorException(ErrorCodes.OBJECT_NULL, "更新普通用户信息失败，找不到对应的普通用户信息");
        }
        BeanUtils.copyProperties(bean, wechatMember);
        wechatMemberDao.save(wechatMember);
        return retailMember;
    }

    /**
     * 查询分销店铺详情
     *
     * @param memberId 分销会员id
     * @return
     */
    public Object findMemberShop(int memberId) {
        return retailShopDao.findByMemberId(memberId);
    }

    /**
     * 修改分销店铺信息
     *
     * @param bean
     * @param shopId
     * @return
     */
    public Object updateMemberShop(RetailShopBean bean, int shopId) {
        RetailShop shop = retailShopDao.findOne(shopId);
        BeanUtils.copyProperties(bean, shop);
        shop.setUpdDate(new Date());
        retailShopDao.save(shop);
        return shop;
    }

    /**
     * 分销店铺商品列表
     *
     * @param search
     * @return
     */
    public Object findShopGoodsByPage(RetailShopSearch search) {
        Sort sort = new Sort(Sort.Direction.DESC, "goodsId");
        Pageable pageable = new PageRequest(search.getPageNo() - 1, search.getPageSize(), sort);
        Page<RetailShopGood> page = shopGoodsDao.findAll(new Specification<RetailShopGood>() {
            @Override
            public Predicate toPredicate(Root<RetailShopGood> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate where = cb.conjunction();
                if(search != null && search.getMemberId() != -1){
                    Path<Integer> memberId = root.get("memberId");
                    where = cb.and(where, cb.equal(memberId, search.getMemberId()));
                }
                if(search != null && !StringUtils.isEmpty(search.getGoodsName())){
                    Path<String> goodsName = root.get("goodsName");
                    where = cb.and(where, cb.equal(goodsName, "%" + search.getGoodsName() + "%"));
                }
                query.where(where);
                return null;
            }
        }, pageable);
        return page;
    }

    /**
     * 分销商品下架
     *
     * @param goodsId
     * @return
     */
    public Object unshelved(int goodsId) {
        RetailShopGood retailShopGood = shopGoodsDao.findOne(goodsId);
        retailShopGood.setUpdateTime(new Date());
        retailShopGood.setStatus(2);
        return shopGoodsDao.save(retailShopGood);
    }
}
