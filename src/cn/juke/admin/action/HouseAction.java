package cn.juke.admin.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import cn.juke.admin.service.HouseService;
import cn.juke.admin.serviceImpl.HouseServiceImpl;
import cn.juke.bean.House;
import cn.juke.util.Page;

import com.opensymphony.xwork2.ModelDriven;

public class HouseAction extends BaseAction implements ModelDriven<House> {

	private HouseService hs = new HouseServiceImpl();
	private House house;
	private List<House> houses;

	private Long hid;
	
	private Page page;

	private int operate;

	public int getOperate() {
		return operate;
	}
    
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	public void setOperate(int operate) {
		this.operate = operate;
	}

	private File[] img; // 上传的文件
	private String[] imgFileName; // 文件名称
	private String[] imgContentType; // 文件类型

	private String[] pics;

	public String[] getPics() {
		return pics;
	}

	public void setPics(String[] pics) {
		this.pics = pics;
	}

	public File[] getImg() {
		return img;
	}

	public void setImg(File[] img) {
		this.img = img;
	}

	public String[] getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String[] imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String[] getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String[] imgContentType) {
		this.imgContentType = imgContentType;
	}

	public Long getHid() {
		return hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
	}

	@Override
	public House getModel() {
		if (house == null)
			house = new House();
		return house;
	}

	public House getHouse() {
		return house;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

	public String list() {
		Long comid=(Long)getSession().get("comid");
		String username=(String)getSession().get("username");
		if(page==null){
			page=new Page();
			page.setPageIndex(1);
		}
		if("admin".equals(username)){
		houses = hs.search(page);
		}
		else houses = hs.search(page,comid);
		return SUCCESS;
	}

	public String detail() {
		house = hs.getHouse(hid);
		if(pics!=null)
		pics = house.getPicture().split(",");
		if (operate == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public List<House> getHouses() {
		return houses;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public String add() throws Exception {
		String realpath = application.getRealPath("/admin/images/houses");
		StringBuilder picture = new StringBuilder("");
		if (img != null) {
			File savedir = new File(realpath);
			if (!savedir.getParentFile().exists())
				savedir.getParentFile().mkdirs();
			pics = new String[img.length];
			for (int i = 0; i < img.length; i++) {
				String[] entireName = imgFileName[i].split("\\.");
				String filename = entireName[0];
				System.out.println(filename);
				File savefile = new File(savedir, filename + ".JPG");
				pics[i] = filename;
				picture.append(filename);
				if (i < img.length - 1)
					picture.append(",");

				FileUtils.copyFile(img[i], savefile);
			}
			house.setPicture(picture.toString());
			house.setModifyTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		Long comid=(Long)getSession().get("comid");
		house.setComid(comid);
		
		hs.create(house);
		return SUCCESS;
	}

	public String update() throws Exception {
		House dHouse = hs.getHouse(hid);
		dHouse.setName(house.getName());
		dHouse.setDeveloper(house.getDeveloper());
		dHouse.setArea(house.getArea());
		dHouse.setModifyTime(house.getModifyTime());
		dHouse.setBtype(house.getBtype());
		dHouse.setDiscount(house.getDiscount());
		dHouse.setDescr(house.getDescr());
		dHouse.setPrice(house.getPrice());
		dHouse.setSaleTime(house.getSaleTime());
		dHouse.setAdress(house.getAdress());
		dHouse.setSalePhone(house.getSalePhone());
		dHouse.setTransport(house.getTransport());
		dHouse.setRelat(house.getRelat());
		if (img!=null) {
			String realpath = application.getRealPath("/images/houses");
			StringBuilder picture = new StringBuilder("");
			File savedir = new File(realpath);
			if (!savedir.getParentFile().exists())
				savedir.getParentFile().mkdirs();
			pics = new String[img.length];
			for (int i = 0; i < img.length; i++) {
				String[] entireName = imgFileName[i].split("\\.");
				String filename = entireName[0];
				System.out.println(filename);
				File savefile = new File(savedir, filename + ".JPG");
				pics[i] = filename;
				picture.append(filename);
				if (i < img.length - 1)
					picture.append(",");
				FileUtils.copyFile(img[i], savefile);
			}
			dHouse.setPicture(picture.toString());
		}
		hs.update(dHouse);
		return SUCCESS;
	}
}
