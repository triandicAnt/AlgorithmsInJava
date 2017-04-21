package loadbalancer;

import java.util.HashMap;
import java.util.Map;

public class LoadBalancerTester {

	public static void main(String[] args) {
		// create server nodes
		// test 1
		test1();
		// test 2
		test2();
		// test 3
		test3();
	}
	public static void test1(){
		Map<String, Long> servers = new HashMap<>();
		servers.put("a",1L);
		servers.put("b",1L);
		servers.put("c",8L);
		
		Balancer b = new Balancer(servers);
		Map<String, Long>matches = new HashMap<>();
		for(long i = 0; i<20000;i++){
			String node = b.request();
			matches.put(node, matches.getOrDefault(node, 0L)+1);
		}
		System.out.println(matches);
	}
	public static void test2(){
		Map<String, Long> servers = new HashMap<>();
		servers.put("a",1000000L);
		servers.put("b",1L);
		
		Balancer b = new Balancer(servers);
		Map<String, Long>matches = new HashMap<>();
		for(long i = 0; i<200000000;i++){
			String node = b.request();
			matches.put(node, matches.getOrDefault(node, 0L)+1);
		}
		System.out.println(matches);
	}
	public static void test3(){
		Map<String, Long> servers = new HashMap<>();
		servers.put("a",500L);
		servers.put("b",500L);
		servers.put("c",500L);
		
		Balancer b = new Balancer(servers);
		Map<String, Long>matches = new HashMap<>();
		for(long i = 0; i<200000;i++){
			String node = b.request();
			matches.put(node, matches.getOrDefault(node, 0L)+1);
		}
		System.out.println(matches);
	}

}
