package dev.negycon.booker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainerSection implements ICompositeSection {
	private String title;
	private List<ICompositeSection> subsections;
	
	public ContainerSection(){
		this("Untitled Section");
	}
	public ContainerSection(String title){
		setTitle(title);
		setSubsections(new ArrayList<ICompositeSection>());
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
		this.subsections = subsections;
	}
	@Override
	public ICompositeSection getChild(List<Integer> route) {
		if (route == null) return this;
		if (route.size() == 0) return this;
		if (getSubsections().size() > route.get(0)){
			if(route.size() > 1){
				return getSubsections().get(route.indexOf(0)).getChild(route.subList(1, route.size()));
			} else {
				return getSubsections().get(route.indexOf(0)).getChild(Collections.<Integer> emptyList());
			}
		} else {
			throw new NoSuchSectionException();
		}
	}
	@Override
	public ICompositeSection getChild(int index) {
		if (getSubsections().size() > index){
			return getSubsections().get(index);
		} else {
			throw new NoSuchSectionException();
		}
	}
	@Override
	public final boolean isLeaf() {
		return false;
	}
}
