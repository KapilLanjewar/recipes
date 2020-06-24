package com.cooking.recipes.dag.nodes;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private int id;
	private Node parent;
	private List<Node> children = new ArrayList<>();
	private boolean isRoot = false;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	public boolean isRoot() {
		return isRoot;
	}
	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}
	
	@Override
	public String toString() {
		return "Node [id=" + id + ", parent=" + parent + ", children=" + children.size() + "]";
	}
	
}
