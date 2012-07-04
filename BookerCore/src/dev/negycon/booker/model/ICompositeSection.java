package dev.negycon.booker.model;

import java.util.List;

public interface ICompositeSection {
	public ICompositeSection getChild(List<Integer> route);
	public ICompositeSection getChild(int index);
	public boolean isLeaf();
	public String getTitle();
	public void setTitle(String title);
	public List<ICompositeSection> getSubsections();
	public void setSubsections(List<ICompositeSection> subsections);
}