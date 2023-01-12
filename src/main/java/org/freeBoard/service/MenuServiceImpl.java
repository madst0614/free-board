package org.freeBoard.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.freeBoard.domain.CategoryVO;
import org.freeBoard.domain.MenuDTO;
import org.freeBoard.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {

	private MenuMapper mapper;

//	public void addChildren(Map<String, CategoryVO> menu, String index, CategoryVO root) {
//		CategoryVO temp = menu.get(index);
//		
//		if(temp.getParent()==null) {
//			root.getChildren().add(temp.getMid());
//		}
//		
//		if(temp.getChildren()==null) {
//			return;
//		}
//			
//		
//	}

//	public CategoryVO createCategoryTree(Map<String, CategoryVO> menu) {
//		log.info("Make Category Root");
//		CategoryVO root = new CategoryVO("root", "루트", null, new ArrayList<CategoryVO>());
//
//		for (String key : menu.keySet()) {
//			CategoryVO current = menu.get(key);
//			CategoryVO parent = menu.get(current.getParent());
//
//			if (parent == null) {
//				root.getChildren().add(current);
//			} else {
//				if(parent.getChildren()==null) {
//					parent.setChildren(new ArrayList<CategoryVO>());
//				}
//
//				parent.getChildren().add(current);
//			}
//		}
//
//		return root;
//	}
	
	public CategoryVO createCategoryTree(List<CategoryVO> list, Map<String, CategoryVO> menu) {
		log.info("Make Category Root");
		CategoryVO root = new CategoryVO("root", "루트", null, new ArrayList<CategoryVO>());

		for (CategoryVO cat : list) {
			String key = cat.getMid();
			CategoryVO current = menu.get(key);
			CategoryVO parent = menu.get(current.getParent());

			if (parent == null) {
				root.getChildren().add(current);
			} else {
				if(parent.getChildren()==null) {
					parent.setChildren(new ArrayList<CategoryVO>());
				}

				parent.getChildren().add(current);
			}
		}

		return root;
	}

	public List<CategoryVO> getList(){
		return mapper.getList();
	}
	
	public Map<String, CategoryVO> getCatMap(List<CategoryVO> list) {
		log.info("Get CategoryList");
		Map<String, CategoryVO> result = new HashMap<String, CategoryVO>();

		list.forEach(category -> {
			result.put(category.getMid(), category);
		});

		return result;
	}
	
	public MenuDTO getMenu(List<CategoryVO> list) {
		MenuDTO result = new MenuDTO();
		
		result.setRoot(this.createCategoryTree(list, this.getCatMap(list)));
		return result;
	}

}
