package cn.juke.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import cn.juke.admin.service.BrokerService;
import cn.juke.admin.service.CustomerService;
import cn.juke.admin.service.HouseService;
import cn.juke.admin.service.RoleService;
import cn.juke.admin.serviceImpl.BrokerServiceImpl;
import cn.juke.admin.serviceImpl.CustomerServiceImpl;
import cn.juke.admin.serviceImpl.HouseServiceImpl;
import cn.juke.admin.serviceImpl.RoleServiceImpl;
import cn.juke.bean.Broker;
import cn.juke.bean.Customer;
import cn.juke.bean.House;
import cn.juke.bean.Role;

public class TestDB {

	public static void testHosue() {
		HouseService hs = new HouseServiceImpl();
		String[] hnames = new String[] { "领秀慧谷", "首城国际", "百环家园", "龙城花园" };
		String[] dnames = new String[] { "恒大", "万达", "绿城", "SOHU" };
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			House h = new House();
			h.setAdress("XXXXX" + i + "号");
			h.setArea("90-120");
			h.setBtype("清水房");
			h.setCity("北京");
			h.setName(hnames[rand.nextInt(3)]);
			h.setComid("01");
			h.setDescr("好地方");
			h.setDeveloper(dnames[rand.nextInt(3)]);
			h.setDiscount("昌平");
			h.setDtype("经济型");
			h.setPrice(rand.nextInt(200));
			h.setSaleAdress("fsdfsd" + i);
			h.setFeature("fsd121232" + i);
			h.setModifyTime(new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date()));
			h.setProvince("北京");
			h.setSaleTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			h.setSalePhone("12322");
			h.setStop(1022 + "");
			h.setTransport("xasdasdf");
			hs.create(h);
		}
	}

	public static void testCustomer() {

		CustomerService hs = new CustomerServiceImpl();
		String[] hnames = new String[] { "高亚东", "徐亮", "将按过", "逗比" };
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			Customer c = new Customer();
		
			c.setComid("01");
			
			c.setStatus(i % 6);
			c.setWeixin("weixinid" + i);
			c.setQq("QQID" + i);
			c.setName(hnames[rand.nextInt(4)] + i);
			c.setPhone("phoneNo" + i);
			
			c.setDealer("负责人" + i);
			hs.create(c);
		}
	}

	public static void testBroker() {

		BrokerService hs = new BrokerServiceImpl();
		String[] hnames = new String[] { "秦友全", "黄俊", "丑娃", "谢启元" };
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			Broker c = new Broker();
			c.setDealNum(3);
			c.setAccount("account" + i);
			c.setBank(i % 5 + "bank");
			c.setPhone("PhoneNO" + i);
			c.setState(rand.nextInt(1));
			c.setName(hnames[rand.nextInt(4)] + i);
			c.setPhone("phoneNo" + i);
			hs.create(c);
		}
	}

	public static void testRoles() {
		RoleService hs = new RoleServiceImpl();
		for (int i = 0; i < 5; i++) {
			Role role = new Role(new Long(i), "name" + i, "01", "desc" + i);
			hs.create(role);
		}
	}

	public static void main(String[] a) {
		testRoles();
	}
}
