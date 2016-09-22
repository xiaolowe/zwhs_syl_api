package cn.org.citycloud.zwhs.syl.service;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.citycloud.zwhs.syl.bean.TopBean;
import cn.org.citycloud.zwhs.syl.repository.TopOrderDao;

/**
 * @author Allen
 */

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class TopOrderService {
	@Autowired
	private TopOrderDao topOrderDao;
	
	/**
	 * 获取首页top10 数据
	 * @return
	 */
	public List<TopBean> getMoneyTop10(){
		
		List<TopBean> list =  topOrderDao.findMoneyTop10();
		List<TopBean> listout = new ArrayList<TopBean>();
		for(int i = 0; i < list.size() ; i++){
			Object obj = list.get(i);
			Object[] objArray = (Object[])obj;
			String province = (String)objArray[0];
			String city = (String)objArray[1];
			BigInteger storenum = (BigInteger)objArray[2];
			BigInteger ordernum = (BigInteger)objArray[3];
			BigDecimal ordermoney = (BigDecimal)objArray[4];
			TopBean topBean = new TopBean(province, city, storenum, ordernum, ordermoney);
			listout.add(topBean);
			
		}
		
		return listout;
	}
}
