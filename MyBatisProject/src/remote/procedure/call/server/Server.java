package remote.procedure.call.server;

import java.io.IOException;

//服务中心
public interface Server {
	public void start() ;
	public void stop();
	//注册服务
	public void register(Class service,Class serviceImpl);
	//...
}
