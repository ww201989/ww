package remote.procedure.call.server;

import java.io.IOException;

//��������
public interface Server {
	public void start() ;
	public void stop();
	//ע�����
	public void register(Class service,Class serviceImpl);
	//...
}
