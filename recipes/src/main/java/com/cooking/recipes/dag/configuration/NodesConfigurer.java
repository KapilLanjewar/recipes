package com.cooking.recipes.dag.configuration;

import com.cooking.recipes.dag.nodes.Node;

public interface NodesConfigurer {

	public void createRootNode(int id);
	public Node getRootNode();
	public Node getNode(int id);
	public void linkNode(int target, int linking);
	public void unlinkNode(int id);
	
}
