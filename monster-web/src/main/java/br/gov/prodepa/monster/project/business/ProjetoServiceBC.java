package br.gov.prodepa.monster.project.business;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.prodepa.monster.project.domain.Projeto;
import br.gov.prodepa.monster.project.dto.search.CommonSearchsDto;

@Stateless
public class ProjetoServiceBC extends JPACrud<Projeto, Long> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void insert(Projeto entity) {
		// TODO Auto-generated method stub
		super.insert(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		super.delete(id);
	}

	@Override
	public void update(Projeto entity) {
		// TODO Auto-generated method stub
		super.update(entity);
	}

	@Override
	public Projeto load(Long id) {
		// TODO Auto-generated method stub
		return super.load(id);
	}

	@Override
	public List<Projeto> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	public List<Projeto> findByExample(CommonSearchsDto dto) {
		// TODO Novamente, ver forma melhor de fazer isso
		if(dto == null) {
			return findByExample(new Projeto());
		} else {
			System.out.println(">>>>>>>> " + dto.getPattern());
			return findByExample(new Projeto(dto.getPattern()));
		}
		
	}
	
	
	
	/*protected List<T> findByExample(final T example) {
		final CriteriaQuery<T> criteria = createCriteriaByExample(example);
		return getEntityManager().createQuery(criteria).getResultList();
	}*/

	@Override
	protected List<Projeto> findByExample(Projeto example) {
		final CriteriaQuery<Projeto> criteria = createCriteriaByExample(example);
		return getEntityManager().createQuery(criteria).getResultList();
	}

	/**
	 * Support method which will be used for construction of criteria-based queries.
	 * 
	 * @param example
	 *            an example of the given entity
	 * @return an instance of {@code CriteriaQuery}
	 */
	private CriteriaQuery<Projeto> createCriteriaByExample(final Projeto example) {

		final CriteriaBuilder builder = getCriteriaBuilder();
		final CriteriaQuery<Projeto> query = builder.createQuery(getBeanClass());
		final Root<Projeto> entity = query.from(getBeanClass());

		final List<Predicate> predicates = new ArrayList<Predicate>();
		final Field[] fields = example.getClass().getDeclaredFields();

		for (Field field : fields) {

			if (!field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(Basic.class)
					&& !field.isAnnotationPresent(Enumerated.class)) {
				continue;
			}

			Object value = null;

			try {
				field.setAccessible(true);
				value = field.get(example);
			} catch (IllegalArgumentException e) {
				continue;
			} catch (IllegalAccessException e) {
				continue;
			}

			if (value == null) {
				continue;
			}
			
			
			if(field.getType().equals(String.class)) {
				final Predicate pred = builder.like(entity.get(field.getName()).as(String.class), "%"+(String)value + "%");
				predicates.add(pred);
			} else {
				final Predicate pred = builder.equal(entity.get(field.getName()), value);
				predicates.add(pred);
			}

		}
		return query.where(predicates.toArray(new Predicate[0])).select(entity);
	}
	
}
