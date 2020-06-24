package com.cooking.recipes.dag.nodes.processors;

import java.util.List;

import com.cooking.recipes.dag.nodes.Node;

public interface NodesArrangementProcessor {

	public List<String> getNodePaths(Node arrangement);
	
}
