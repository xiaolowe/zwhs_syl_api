package cn.org.citycloud.zwhs.syl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import cn.org.citycloud.zwhs.syl.entity.FinAcc;
import cn.org.citycloud.zwhs.syl.repository.FinAccDao;
/**
 * 
 * @author Allen
 *
 */

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class FinAccService {
	@Autowired
	private FinAccDao finAccDao;
	
	/**
	 * 添加账号余额
	 * @param accNo
	 * @param applyMoney
	 * @return
	 */
	public FinAcc modifyCashRecoderByState(Integer accNo, Double applyMoney){
		
		FinAcc finAcc = finAccDao.findFinaccByAccNo(accNo);
		Double accbal = finAcc.getAccBal();
		accbal = accbal + applyMoney;
		
		finAcc.setAccBal(accbal);
		
		return finAccDao.save(finAcc);
	}
	
	/**
	 * 通过账户编号获取信息
	 * @param accNo
	 * @return
	 */
	public FinAcc getFinAccByAccNo(Integer accNo){
		
		return finAccDao.findFinaccByAccNo(accNo);
	}
	
}
