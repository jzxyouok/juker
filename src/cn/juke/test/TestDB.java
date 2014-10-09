package cn.juke.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

import cn.juke.admin.service.BrokerService;
import cn.juke.admin.service.CompanyService;
import cn.juke.admin.service.CustomerService;
import cn.juke.admin.service.DealService;
import cn.juke.admin.service.HouseService;
import cn.juke.admin.service.UserService;
import cn.juke.admin.serviceImpl.BrokerServiceImpl;
import cn.juke.admin.serviceImpl.CompanyServiceImpl;
import cn.juke.admin.serviceImpl.CustomerServiceImpl;
import cn.juke.admin.serviceImpl.DealServiceImpl;
import cn.juke.admin.serviceImpl.HouseServiceImpl;
import cn.juke.admin.serviceImpl.UserServiceImpl;
import cn.juke.bean.Broker;
import cn.juke.bean.Company;
import cn.juke.bean.Customer;
import cn.juke.bean.Deal;
import cn.juke.bean.House;
import cn.juke.bean.User;

public class TestDB {

	@Test
	public static void testHosue() {
		HouseService hs = new HouseServiceImpl();
		String[] hnames = new String[] { "领秀慧谷", "首城国际", "百环家园", "龙城花园" };
		String[] dnames = new String[] { "恒大", "万达", "绿城", "SOHU" };
		Random rand = new Random();
		for (int i = 0; i < 50; i++) {
			House h = new House();
			h.setAdress("XXXXX" + i + "号");
			h.setArea("90-120");
			h.setBtype("清水房");
			h.setCity("北京");
			h.setName(hnames[rand.nextInt(3)]);
			h.setDescr("好地方");
			h.setDeveloper(dnames[rand.nextInt(3)]);
			h.setDiscount(Math.random()+"");
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

	@Test
	public static void testCustomer() {
		CustomerService hs = new CustomerServiceImpl();
		String[] hnames = new String[] { "高亚东", "徐亮", "将按过", "逗比" };
		Random rand = new Random();
		for (int i = 0; i < 50; i++) {
			Customer c = new Customer();
			c.setWeixin("weixinid" + i);
			c.setQq("QQID" + i);
			c.setName(hnames[rand.nextInt(4)] + i);
			c.setPhone("phoneNo" + i);
			hs.create(c);
		}
	}

	@Test
	public static void testBroker() {
		BrokerService hs = new BrokerServiceImpl();
		String[] hnames = new String[] { "秦友全", "黄俊", "丑娃", "谢启元" };
		Random rand = new Random();
		for (int i = 0; i < 30; i++) {
			Broker c = new Broker();
			c.setDealNum(3);
			c.setAccount("account" + i);
			c.setBank(i % 5 + "bank");
			c.setPhone("PhoneNO" + i);
			c.setState(rand.nextInt(2));
			c.setCreatetime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			c.setName(hnames[rand.nextInt(4)] + i);
			c.setPhone("phoneNo" + i);
			hs.create(c);
		}
	}
	
	public static void testDeal() {
		DealService hs = new DealServiceImpl();
		String[] unames=new String[]{"wangerxiao","zhangsan","lisi","wangwu"};
		Random rand = new Random();
		for (int i = 0; i < 50; i++) {
			Deal c = new Deal();
			c.setBroker_id(new Long(rand.nextInt(25)+2));
			c.setCstate(rand.nextInt(1)+"");
			c.setStatus(rand.nextInt(5));
			c.setComid(new Long(rand.nextInt(3)+2));
			c.setCustomer_id(new Long(i));
			if(c.getStatus()>=2)
				c.setDealer(unames[rand.nextInt(4)]);
			c.setDealtime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			c.setMoney(new Double(i+200));
			c.setCommision(new Double(i+10));
			c.setHouse_id(new Long(i));
			c.setHouse_type(rand.nextInt(5)+1);
		
			c.setCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));	
			hs.create(c);
		}
	}
	
	public static void testCompany(){
		CompanyService cs=new CompanyServiceImpl();
		String[] dnames = new String[] { "恒大", "万达", "绿城", "SOHU" };
		Random rand=new Random();
		for(int i=2;i<6;i++){
			Company c=new Company();
			c.setAddress("XXXXX"+i+"号");
			c.setEmail("eamilXXXX"+i+"@qq.com");
			c.setName(dnames[i-2]);
			c.setPhone("phonenum"+i+i+i);
			cs.create(c);
		}
	}
	
	@Test
	public static void testUser(){
		CompanyService cs=new CompanyServiceImpl();
		String[] dnames = new String[] { "恒大", "万达", "绿城","SOHU" };
		String[] unames=new String[]{"wangerxiao","zhangsan","lisi","wangwu"};
		String[] cnames=new String[]{"王小二","张三","李四","王五"};
		UserService us=new UserServiceImpl();
		for(int i=2;i<6;i++){
			Company c=cs.get(new Long(i));
			User u=new User();
			u.setCompany(c);
			u.setCreate_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			u.setQq("QQ"+i+i+i+i);
			u.setPassword("e10adc3949ba59ab");
			u.setEmail("eamilXXXX"+i+"@qq.com");
			u.setName(cnames[i-2]);
			u.setState(1+"");
		    u.setUsername(unames[i-2]);
		    us.create(u);
		}
	}
	
	public static void main(String[] a){
		testHosue();
		testCustomer();
		testBroker();
		testDeal();
		testCompany();
		testUser();
	}
}
