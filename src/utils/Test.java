package utils;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import DAO.PosterDAO;
import entity.Poster;

public class Test {

	public static void main(String args[]){
			PosterDAO posterDAO = PosterDAO.getInstance();
			List<Poster> posters = posterDAO.getAll();
			for(Poster poster : posters){
				System.out.println(poster.getPosterTitle());
			}
	 }

}
