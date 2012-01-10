
import java.util.Timer;
import java.util.TimerTask;

/* 很簡單的2行：timer跟timer.schedule
 * 1.new一個timer物件，
 * 2.使用timer.schedule方法
 *  schedule的參數，第一個是一個TimerTask物件，第二個是『從現在開始，經過幾秒後執行』，第三個是「每隔幾秒執行一次」。
 *  每次時間到了就會執行TimerTask物件裡面的「run()」函數
 */
public class A {
	public static void main(String [] args){
		// 1.new一個timer物件
		Timer timer = new Timer();
		
		// 2.使用timer.schedule()方法
		timer.schedule(new C("我是傳進去的參數"), 2000,1000);
		/* 參數new C()是一個TimerTask物件
		 * 參數2000是指『從現在開始，經過2秒後執行』
		 * 參數1000第三個是「每隔1秒執行一次」。
		 */
		
	}
	
}

class C extends TimerTask{
	public String argument;
	
	public C(String argument){
		this.argument = argument;
	}
	
	@Override
	public void run() {
		System.out.println("時間到了，執行run()函數！ 收到參數：" + argument);
	}
}