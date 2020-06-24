package com.cooking.recipes.dag.nodes.processors;

import java.util.ArrayList;
import java.util.List;

import com.cooking.recipes.dag.nodes.Node;

public class DAGNodesArrangementProcessor implements NodesArrangementProcessor {

	public static Node getNode(Node arrangement, int id)
	{
		return traverse(arrangement, id);
	}
	
	private static Node traverse(Node arrangement, int id)
	{
		Node result = null;
		
		for(Node leaf: arrangement.getChildren())
		{
			if(leaf.getId() == id)
			{
				result = leaf;
				break;
			}
			else if(leaf.getChildren().size() > 0)
			{
				result = traverse(leaf, id);
			}
		}
		
		return result;
	}
	
	public List<String> getNodePaths(Node arrangement)
	{
		List<String> paths = new ArrayList<>();
		StringBuilder construct = new StringBuilder().append(arrangement.getId() + "->");
		
		traversePaths(arrangement, construct, paths);
		
		return paths;
	}
	
	private static void traversePaths(Node arrangement, StringBuilder construct, List<String> paths)
	{
		for(Node leaf: arrangement.getChildren())
		{
			StringBuilder copy = new StringBuilder(construct);
			copy.append(leaf.getId() + "->");
			
			if(leaf.getChildren().size() > 0)
			{
				traversePaths(leaf, copy, paths);
			}
			else
			{
				copy = copy.delete(copy.length()-2, copy.length());
				paths.add(copy.toString());
			}
		}
	}
}
