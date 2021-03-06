package cn.org.citycloud.zwhs.syl.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import cn.org.citycloud.zwhs.syl.entity.CashRecoder;
import cn.org.citycloud.zwhs.syl.repository.CashRecoderDao;

/**
 * 
 * @author Allen
 *
 */

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class CashRecoderService {
	@Autowired
	private CashRecoderDao cashRecoderDao;
	@Autowired
	private FinAccService finAccService;
	
	/**
	 * 动态查询支出款项列表
	 * @param pageable
	 * @param storeOrder
	 * @return
	 */
	public Page<CashRecoder> getCashRecoderPage(Pageable pageable, CashRecoder cashRecoder, String startTime, String endTime){
		
		Page<CashRecoder> page = cashRecoderDao.findAll(new Specification<CashRecoder>() {
			@Override
			public Predicate toPredicate(Root<CashRecoder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				if(cashRecoder != null && cashRecoder.getCashNo() != null){
					Path<String> cashNo = root.get("cashNo");  
					where = cb.and(where, cb.equal(cashNo, cashRecoder.getCashNo())); 
					
				}
				if(cashRecoder != null && StringUtils.isNotBlank(cashRecoder.getCompanyName())){
					Path<String> companyName = root.get("companyName");  
					where = cb.and(where, cb.like(companyName, "%"+cashRecoder.getCompanyName()+"%"));
					
				}
				if(cashRecoder != null && cashRecoder.getConfirmStat() != null ){
					Path<String> confirmStat = root.get("confirmStat");  
					where = cb.and(where, cb.equal(confirmStat, cashRecoder.getConfirmStat()));
				}
				if(cashRecoder != null && cashRecoder.getAccType() != null ){
					Path<String> accType = root.get("accType");  
					where = cb.and(where, cb.equal(accType, cashRecoder.getAccType()));
				}
				if(cashRecoder != null && StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)){
					Path<Date> applyTime = root.get("applyTime"); 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date start = new Date();
					Date end = new Date();
					String startime1 = startTime + " 00:00:00";
					String endtime1 = endTime + " 23:59:59";
					try {
						start = sdf.parse(startime1);
						end = sdf.parse(endtime1);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					where = cb.and(where, cb.between(applyTime, start, end)); 
					
				}
				query.where(where);
				  
			    return null;   
			}
		}, pageable);
		
	    return page;
	}
	
	
	/**
	 * 动态查询支出款项列表
	 * @param pageable
	 * @param storeOrder
	 * @return
	 */
	public List<CashRecoder> getCashRecoderList(CashRecoder cashRecoder, String startTime, String endTime){
		
		List<CashRecoder> list = cashRecoderDao.findAll(new Specification<CashRecoder>() {
			@Override
			public Predicate toPredicate(Root<CashRecoder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				if(cashRecoder != null && cashRecoder.getCashNo() != null){
					Path<String> cashNo = root.get("cashNo");  
					where = cb.and(where, cb.equal(cashNo, cashRecoder.getCashNo())); 
					
				}
				if(cashRecoder != null && StringUtils.isNotBlank(cashRecoder.getCompanyName())){
					Path<String> companyName = root.get("companyName");  
					where = cb.and(where, cb.like(companyName, "%"+cashRecoder.getCompanyName()+"%"));
					
				}
				if(cashRecoder != null && cashRecoder.getConfirmStat() != null ){
					Path<String> confirmStat = root.get("confirmStat");  
					where = cb.and(where, cb.equal(confirmStat, cashRecoder.getConfirmStat()));
				}
				if(cashRecoder != null && StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)){
					Path<Date> applyTime = root.get("applyTime"); 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date start = new Date();
					Date end = new Date();
					String startime1 = startTime + " 00:00:00";
					String endtime1 = endTime + " 23:59:59";
					try {
						start = sdf.parse(startime1);
						end = sdf.parse(endtime1);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					where = cb.and(where, cb.between(applyTime, start, end)); 
					
				}
				query.where(where);
				  
			    return null;   
			}
		});
		
	    return list;
	}
	
	
	/**
	 * 根据支付单号查询支付信息
	 * @param cashNo
	 * @return
	 */
	public CashRecoder getCashRecoder(Integer cashNo){
		
		return cashRecoderDao.findOne(cashNo);
	}
	
	
	/**
	 * 审核通过
	 * @param cashNo
	 * @param cashRecoder
	 * @return
	 */
	public CashRecoder modifyCashRecoderByState(Integer cashNo, CashRecoder cashRecoder){
		
		CashRecoder cash = cashRecoderDao.findOne(cashNo);
		
		if(cashRecoder != null && cashRecoder.getConfirmStat() != null){
			cash.setConfirmStat(cashRecoder.getConfirmStat());
		}
		if(cashRecoder != null && StringUtils.isNotBlank(cashRecoder.getConfirmUserName())){
			cash.setConfirmUserName(cashRecoder.getConfirmUserName());
		}
		if(cashRecoder != null && cashRecoder.getConfirmTime() != null){
			cash.setConfirmTime(cashRecoder.getConfirmTime());
		}
		if(cashRecoder != null && cashRecoder.getUpdDate() != null){
			cash.setUpdDate(cashRecoder.getUpdDate());
		}
		
		
		return cashRecoderDao.save(cash);
	}
	
	/**
	 * 驳回
	 * @param cashNo
	 * @param cashRecoder
	 * @return
	 */
	public CashRecoder modifyCashRecoderRejectByState(Integer cashNo, CashRecoder cashRecoder){
		
		CashRecoder cash = cashRecoderDao.findOne(cashNo);
		
		if(cashRecoder != null && cashRecoder.getConfirmStat() != null){
			cash.setConfirmStat(cashRecoder.getConfirmStat());
		}
		if(cashRecoder != null && StringUtils.isNotBlank(cashRecoder.getConfirmUserName())){
			cash.setConfirmUserName(cashRecoder.getConfirmUserName());
		}
		if(cashRecoder != null && cashRecoder.getConfirmTime() != null){
			cash.setConfirmTime(cashRecoder.getConfirmTime());
		}
		if(cashRecoder != null && cashRecoder.getUpdDate() != null){
			cash.setUpdDate(cashRecoder.getUpdDate());
		}
		
		Double applyMoney = cash.getApplyMoney();
		Integer storeId = cash.getStoreId();
		finAccService.modifyCashRecoderByState(storeId, applyMoney);
		
		return cashRecoderDao.save(cash);
	}
	
	
	/**
	 * 
	 * @param cashNo
	 * @param cashRecoder
	 * @return
	 */
	public CashRecoder payMoneyCashRecoderByState(Integer cashNo, CashRecoder cashRecoder){
		
		CashRecoder cash = cashRecoderDao.findOne(cashNo);
		
		if(cashRecoder != null && cashRecoder.getConfirmStat() != null){
			cash.setConfirmStat(cashRecoder.getConfirmStat());
		}
		if(cashRecoder != null && StringUtils.isNotBlank(cashRecoder.getPayingUserName())){
			cash.setPayingUserName(cashRecoder.getPayingUserName());
		}
		if(cashRecoder != null && cashRecoder.getPayingCertificate() != null){
			cash.setPayingCertificate(cashRecoder.getPayingCertificate());
		}
		if(cashRecoder != null && cashRecoder.getPayingTime() != null){
			cash.setPayingTime(cashRecoder.getPayingTime());
		}
		if(cashRecoder != null && cashRecoder.getUpdDate() != null){
			cash.setUpdDate(cashRecoder.getUpdDate());
		}
		
		return cashRecoderDao.save(cash);
	}
	
	public Long getCashByUncheck(){
		
		return cashRecoderDao.findCashByUncheck();
	}
	
	public Long getCashByUnPay(){
		
		return cashRecoderDao.findCashByUnPay();
	}
	
}
