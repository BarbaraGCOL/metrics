package br.com.metrics.dao;

import java.util.List;

import br.com.metrics.model.Project;
import br.com.metrics.model.Update;

/**
 *
 * @author barbara.lopes
 */
public interface ProjectDao {
    public void saveOrUpdate(Project project);
	public void delete(Project project);
	public List<Project> list();
    public Update lastUpdate(Project project);
}
