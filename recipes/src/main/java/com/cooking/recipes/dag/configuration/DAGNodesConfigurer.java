package com.cooking.recipes.dag.configuration;

import java.util.HashMap;
import java.util.Map;

import com.cooking.recipes.dag.nodes.Node;
import com.cooking.recipes.dag.nodes.factory.NodeFactory;
import com.cooking.recipes.dag.nodes.processors.DAGNodesArrangementProcessor;

public class DAGNodesConfigurer implements NodesConfigurer {

	private Node root = null;
	private static Map<Integer, Node> registry = new HashMap<>();
	
	public void createRootNode(int id)
	{
		Node root = NodeFactory.create(id);
		root.setRoot(true);
		
		registry.put(id, root);
		this.root = root;
	}
	
	public Node getRootNode()
	{
		return root;
	}
	
	public Node getNode(int id)
	{
		return registry.get(id);
	}
	
	public void linkNode(int target, int linking)
	{
		if(root == null)
		{
			throw new RuntimeException("Root isn't set yet.");
		}
		else if(registry.containsKey(linking) && isDuplicateLeafNode(registry.get(target), linking))
		{
			throw new RuntimeException("Element already present.");
		}
		else if(registry.containsKey(target))
		{
			Node linkingNode = NodeFactory.create(linking);
			registry.put(linking, linkingNode);
			
			Node targetNode = registry.get(target);
			targetNode.getChildren().add(linkingNode);
			linkingNode.setParent(targetNode);
		}
		else
		{
			throw new RuntimeException("Target node doesn't exist.");
		}
	}
	
	public void unlinkNode(int id)
	{
		if(root != null && root.getId() == id)
		{
			root = null;
			registry.clear();
		}
		else if(registry.containsKey(id))
		{
			Node linking = DAGNodesArrangementProcessor.getNode(root, id);
			Node parent = linking.getParent();
			parent.getChildren().remove(linking);
			registry.remove(id);
		}
		else
		{
			throw new RuntimeException("Node to be deleted doesn't exist.");
		}
	}
	
	private static boolean isDuplicateLeafNode(Node target, int leafId)
	{
		if(target.getChildren().size() == 0)
		{
			return false;
		}
		
		for(Node leaf: target.getChildren())
		{
			if(leaf.getId() == leafId)
			{
				return true;
			}
		}
		
		return false;
	}
	
}
