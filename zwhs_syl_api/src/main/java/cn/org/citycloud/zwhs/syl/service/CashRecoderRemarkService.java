package cn.org.citycloud.zwhs.syl.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import cn.org.citycloud.zwhs.syl.entity.CashRecoderRemark;
import cn.org.citycloud.zwhs.syl.repository.CashRecoderRemarkDao;

/**
 * 
 * @author Allen
 *
 */
//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class CashRecoderRemarkService {
	
	@Autowired
	private CashRecoderRemarkDao cashRecoderRemarkDao;
	
	
	public CashRecoderRemark addCashRecoderRemark(CashRecoderRemark cashRecoderRemark){
		
		return	cashRecoderRemarkDao.save(cashRecoderRemark);
	
	}
	
	
	public CashRecoderRemark getCashRemarkByCashNo(Integer cashNo){
		
		return cashRecoderRemarkDao.findRemarkByCashNo(cashNo);
	}
	
	
	
	
	
}
