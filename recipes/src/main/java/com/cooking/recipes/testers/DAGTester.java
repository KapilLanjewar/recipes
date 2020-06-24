package com.cooking.recipes.testers;

import com.cooking.recipes.dag.configuration.DAGNodesConfigurer;
import com.cooking.recipes.dag.configuration.NodesConfigurer;
import com.cooking.recipes.dag.nodes.processors.DAGNodesArrangementProcessor;
import com.cooking.recipes.dag.nodes.processors.NodesArrangementProcessor;

public class DAGTester {

	public static void main(String[] args) {
		
		System.out.println(1);
		
		NodesConfigurer configurer = new DAGNodesConfigurer();
		configurer.createRootNode(1);
		
		configurer.linkNode(1, 2);
		configurer.linkNode(1, 3);
		configurer.linkNode(1, 4);
		configurer.linkNode(1, 5);
		configurer.linkNode(2, 6);
		configurer.linkNode(3, 6);
		configurer.linkNode(3, 7);
		configurer.linkNode(4, 7);
		configurer.linkNode(4, 8);
		configurer.linkNode(5, 8);
		
		NodesArrangementProcessor processor = new DAGNodesArrangementProcessor();
		System.out.println(processor.getNodePaths(configurer.getRootNode()));
		
		System.out.println(2);
		
	}
	
}
