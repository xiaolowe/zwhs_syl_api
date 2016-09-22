package cn.org.citycloud.zwhs.syl.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.citycloud.zwhs.syl.entity.WechatMember;
import cn.org.citycloud.zwhs.syl.repository.WechatMemberDao;

/**
 * @author Allen
 *
 */

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class WechatMemberService {
	@Autowired
	private WechatMemberDao wechatMemberDao;
	
	/**
	 * 动态查询会员列表
	 * @param pageable
	 * @param wechatMember
	 * @return
	 */
	public Page<WechatMember> getWechatMemberPage(Pageable pageable, WechatMember wechatMember){
		
		Page<WechatMember> page = wechatMemberDao.findAll(new Specification<WechatMember>() {
			@Override
			public Predicate toPredicate(Root<WechatMember> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				if(wechatMember != null && StringUtils.isNotBlank(wechatMember.getWechatAliasname())){
					Path<String> wechatAliasname = root.get("wechatAliasname");  
					where = cb.and(where, cb.like(wechatAliasname, "%"+wechatMember.getWechatAliasname()+"%"));
				}
				query.where(where);
				  
			    return null;  
			}
		}, pageable);
		
	    return page;
	}
	
	
	/**
	 * 动态查询会员列表
	 * @param wechatMember
	 * @return
	 */
	public List<WechatMember> getWechatMemberList(WechatMember wechatMember){
		
		List<WechatMember> list = wechatMemberDao.findAll(new Specification<WechatMember>() {
			@Override
			public Predicate toPredicate(Root<WechatMember> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				if(wechatMember != null && StringUtils.isNotBlank(wechatMember.getWechatAliasname())){
					Path<String> wechatAliasname = root.get("wechatAliasname");  
					where = cb.and(where, cb.like(wechatAliasname, "%"+wechatMember.getWechatAliasname()+"%"));
				}
				query.where(where);
				  
			    return null;  
			}
		});
		
	    return list;
	}
	
	/**
	 * 根据会员id查找会员信息
	 * @param memberId
	 * @return
	 */
	public WechatMember getWechatMemberByMemberId(Integer memberId){
		
		return wechatMemberDao.findWechatMemberByMemberId(memberId);
	
	}
}
