package dev.negycon.booker.model;

import java.util.Collections;
import java.util.List;

public class LeafSection implements ICompositeSection{
	
	private String title;
	private List<ICompositeSection> subsections;

	public LeafSection() {
		super();
	}
	public LeafSection(String title) {
		setTitle(title);
		setSubsections(Collections.unmodifiableList(Collections.<ICompositeSection> emptyList()));
	}
	
	@Override
	public final ICompositeSection getChild(List<Integer> route) {
		if(route == null) return this;
		if(route.size() == 0) return this;
		throw new NoSuchSectionException();
	}

	@Override
	public final ICompositeSection getChild(int index) {
		if (index != 0) throw new NoSuchSectionException();
		return this;
	}

	@Override
	public final boolean isLeaf() {
		return true;
	}
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public List<ICompositeSection> getSubsections() {
		return subsections;
	}
	@Override
	public void setSubsections(List<ICompositeSection> subsections) {
		// NOTHING TO DO HERE
	}
	
}
