package test.fightfive.track.information;

import java.text.ParseException;

import android.test.AndroidTestCase;

import com.fightfive.track.database.DBHelper;
import com.fightfive.track.information.Information;
import com.fightfive.track.information.InformationDao;

public class InformationDaoTest extends AndroidTestCase {

	public void testInsert() throws ParseException {
		DBHelper helper = new DBHelper(getContext());
		InformationDao dao = new InformationDao(helper);
		Information information = new Information();
		information.setSid("sid");
		information.setName("name");
		information.setClass_name("class_name");
		information.setPhone("phone");
		information.setEmail("email");
		information.setCompany_name("company_name");
		information.setCompany_address("company_address");
		information.setModify_time("2014-12-28 10:31:50");
		dao.insert(information);
	}
	
	public void testUpdate() {
		DBHelper helper = new DBHelper(getContext());
		InformationDao dao = new InformationDao(helper);
		Information information = new Information();
		information.setSid("sid");
		information.setName("name");
		information.setClass_name("class_name");
		information.setPhone("phone");
		information.setEmail("email");
		information.setCompany_name("company_name");
		information.setCompany_address("company_address");
		information.setModify_time("2014-12-28 10:31:54");
		int rows = dao.update(information);
		assertEquals(1, rows);
	}

	public void testSelect() {
		DBHelper helper = new DBHelper(getContext());
		InformationDao dao = new InformationDao(helper);
		Information information = dao.select();
		assertEquals("name", information.getName());
	}
}
