package little.ant.blog.member.service;

import com.jfinal.aop.Enhancer;
import com.jfinal.plugin.activerecord.tx.Tx;

import little.ant.platform.service.BaseService;

import org.apache.log4j.Logger;

public class MoveService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(MoveService.class);
	
	public static final MoveService service = Enhancer.enhance(MoveService.class, Tx.class);
	
}