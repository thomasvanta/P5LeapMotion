/**
 * Class representing a TUIO Point
 * @author mohamed.hamzeen
 */
public class TuioPoint {
  private int touchId;
  private int sessionId;
  private float x;
  private float y;
  private float xVel;
  private float yVel;
  private float mAccel;
  private float mSpeed;
  private long timeStamp;

  public TuioPoint(int sId, int tId, float x, float y, long time) {	
		this.sessionId = sId;
		this.touchId = tId;
		this.x = x;
		this.y = y;
		this.xVel = 0.0f;
		this.yVel = 0.0f;
		this.mAccel = 0.0f;
		this.mSpeed = 0.0f;
		this.timeStamp = time;
	}
	
	public int getTouchId() {
		return touchId;
	}

	public void setTouchId(int tId) {
		this.touchId = tId;
	}

	public int getSessionId() {
		return sessionId;
	}
	
	public void update(float x, float y, long time) {
		
		float dt = (time - timeStamp)/1000.0f;
		
		double dx = x - this.x;
		double dy = y - this.y;
		float dist = (float)Math.sqrt(dx*dx+dy*dy);
		float lastSpeed = mSpeed;
		
		xVel = (float)(dx/dt);
		yVel = (float)(dy/dt);
		mSpeed = dist/dt;
		mAccel = (mSpeed - lastSpeed)/dt;
		
		this.x = x;
		this.y = y;
		this.timeStamp = time;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getXVel() {
		return xVel;
	}

	public float getYVel() {
		return yVel;
	}

  public float getAccel() {
    return mAccel;
  }
}
