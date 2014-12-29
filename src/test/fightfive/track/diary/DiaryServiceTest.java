package test.fightfive.track.diary;

import com.fightfive.track.diary.DiaryService;

import android.content.Intent;
import android.test.AndroidTestCase;

public class DiaryServiceTest extends AndroidTestCase {

	public void test() {
		Intent intent = new Intent();
		intent.setClass(getContext(), DiaryService.class);
		getContext().startService(intent);
//		getContext().stopService(intent);
	}
}
