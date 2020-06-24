package com.cooking.recipes.dag.nodes.factory;

import com.cooking.recipes.dag.nodes.Node;

public class NodeFactory {

	public static Node create(int id)
	{
		Node node = new Node();
		node.setId(id);
		
		return node;
	}
	
}
