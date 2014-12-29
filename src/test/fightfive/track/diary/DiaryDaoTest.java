package test.fightfive.track.diary;

import com.fightfive.track.database.DBHelper;
import com.fightfive.track.diary.Diary;
import com.fightfive.track.diary.DiaryDao;

import android.test.AndroidTestCase;

public class DiaryDaoTest extends AndroidTestCase {

	public void testInsert() {
		DBHelper helper = new DBHelper(getContext());
		DiaryDao dao = new DiaryDao(helper);
		Diary diary = new Diary();
		diary.setWeek_id(1);
		diary.setSid("sid");
		diary.setContent("content");
		diary.setHarvest("harvest");
		diary.setSuggestion("suggestion");
		dao.insert(diary);
	}

	public void testSelectByWeekId() {
		DBHelper helper = new DBHelper(getContext());
		DiaryDao dao = new DiaryDao(helper);
		Diary diary = dao.selectByWeekId(1);
		assertEquals("content", diary.getContent());
	}
}
