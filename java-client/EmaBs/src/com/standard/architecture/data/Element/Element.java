package com.standard.architecture.data.Element;

public abstract class Element {
	public abstract void select();
	public abstract void insert();
	public abstract void delete();
	public abstract void update(Element new_element);
}
