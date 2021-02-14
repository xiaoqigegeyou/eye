package cn.until;

/**
 * Note:常量表
 * 
 * @author Administrator
 *
 */
public class CONST {

	/**
	 * Master主机的域名或者IP,从/config/main.properties文件加载
	 */
	public final static String MASTER_DOMAIN = new String("MASTER_DOMAIN");
	/**
	 * MapReduce历史信息主机域名或者IP,从/config/main.properties文件加载
	 */
	public final static String JOBHISTORY = new String("JOBHISTORY");

	/**
	 * MapReduce历史信息主机域名或者IP,从/config/main.properties文件加载
	 */
	public final static String RESOURCEMANGER = new String("RESOURCEMANGER");

	/**
	 * HTTP的协议头 ：
	 */
	public final static String HTTP = "http://";

	/**
	 * HTTPS的协议头
	 */
	public final static String HTTPS = "https://";

	/**
	 * Application信息的Url的尾部 /ws/v1/cluster/apps"
	 */
	public final static String APPLICATION_URL_END = "/ws/v1/cluster/apps";

	/**
	 * /ws/v1/cluster/nodes
	 */
	public final static String NODES_URL_END = "/ws/v1/cluster/nodes/";
	/**
	 * 节点信息URL尾部 :8042/node/allApplications
	 */
	public final static String NODE_URL_END = ":8042/node/allApplications";
	/**
	 * <p>
	 * MapURL地址的中间公共部分
	 * </p>
	 * <code> </code>
	 */
	public static final String MAPURL_ = "/jobhistory/tasks/job_";
	/**
	 * <p>
	 * MapUrl地址的结尾
	 * </p>
	 * <code> </code>
	 */
	public static final String MAPURL_END = "/m";

	/**
	 * <p>
	 * ReduceURL的中间公共部分
	 * </p>
	 * <code> </code>
	 */
	public static final String REDUCEURL_ = "/jobhistory/tasks/job_";
	/**
	 * <p>
	 * ReduceURL的结尾
	 * </p>
	 * <code> </code>
	 */
	public static final String REDUCEURL_END = "/r";

	/**
	 * <p>
	 * Attempt信息页面的公共链接部分，和HTPP RESOURCEMANGER taskid拼接处URL地址
	 * <p>
	 * URL
	 * ：<code>http://domain.com:19888/jobhistory/task/task_1546008605570_0008_m_000000</code>
	 */
	public static final String ATTEMPTURL_ = "/jobhistory/task/";

	/**
	 * <p>
	 * 数据所在的script标签
	 * </p>
	 */
	public static final String DATALOCATION = "script";

	/**
	 * 正在运行的任务
	 */
	public final static String JOB_RUNNING = "RUNNING";
	/**
	 * 在队列中还未运行的任务
	 */
	public final static String JOB_ACCEPTED = "ACCEPTED";

	/**
	 * 解压任务
	 */
	public final static String JOB_Un_Tar = "Un_Tar";

	/**
	 * <p>
	 * MapTask和ReduceTask的name
	 * </p>
	 */
	public static final int TASK_ID = 0;
	/**
	 * <p>
	 * MapTask和ReduceTask状态信息
	 * </p>
	 */
	public static final int TASK_STATE = 1;
	/**
	 * <p>
	 * MapTask和ReduceTask开始时间
	 * </p>
	 */
	public static final int TASK_START_TIME = 2;
	/**
	 * <p>
	 * MapTask和ReduceTask结束时间
	 * </p>
	 */
	public static final int TASK_FINISH_TIME = 3;
	/**
	 * <p>
	 * MapTask和ReduceTask运行时间
	 * </p>
	 */
	public static final int TASK_ELAPSED_TIME = 4;
	/**
	 * <p>
	 * MapTask和ReduceTask的运行节点
	 * </p>
	 */
	public static final int TASK_NODE = 3;

	/*** 数据节点状态 ***/
	// NEW, RUNNING, UNHEALTHY, DECOMMISSIONING, DECOMMISSIONED, LOST, REBOOTED,
	// SHUTDOWN
	/**
	 * 新建的数据节点
	 */
	public static final String NODE_NEW = "NEW";
	/**
	 * 正在运行的数据节点
	 */
	public static final String NODE_RUNNING = "RUNNING";
	/**
	 * 不健康的数据节点
	 */
	public static final String NODE_UNHEALTHY = "UNHEALTHY";
	/**
	 * 即将退役的数据节点
	 */
	public static final String NODE_DECOMMISSIONING = "DECOMMISSIONING";

	/**
	 * 已经退役的数据节点
	 */
	public static final String NODE_DECOMMISSIONED = "DECOMMISSIONED";

	/**
	 * 丢失的数据节点
	 */
	public static final String NODE_LOST = "LOST";

	/**
	 * 正在重启的数据节点
	 */
	public static final String NODE_REBOOTED = "REBOOTED";
	/**
	 * 已经关机的数据节点
	 */
	public static final String NODE_SHUTDOWN = "SHUTDOWN";

}
