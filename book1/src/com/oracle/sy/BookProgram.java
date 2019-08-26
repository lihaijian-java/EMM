package com.oracle.sy;

public class BookProgram {
	/**
	 *  启动图书管理系统
	 */
	public static void start(){		
		//调主菜单，并返回用户在主菜单上输入的数字
		int num = UI.mainMenu();
		
		//如果用户在主菜单输入了1表示要查询所有图书
		if(num == 1){			
			//图书列表
			num = UI.list();
			
			listMenuSel(num);
		}else if(num == 2){			
			//搜索图书 
			num = UI.search();
			
			listMenuSel(num);
			
		}else if(num == 3){
			
			//添加图书
			UI.add();
		}		
	}
	public static void listMenuSel(int num){
		
		if(num == 0){
			//如果用户在图书列表输入了0表示要回主菜单
			start();
			
		}else{
			//如果不是0，则表示查看图书信息
			
			int id = num;
			
			num = UI.detail(id);//1.修改   2.删除  0.返回主菜单
			
			if(num == 1){
				//进入修改UI
				
				UI.update(id);				
			}else if(num == 2){
			
				/*
				 * 执行删除
				 */
				BookDao bookDao = new BookDao();				
				bookDao.delete(id);
			}		
			//回主菜单
			start();			
		}		
	}	
	public static void main(String[] args) {
		
		BookProgram.start();		
	}
}
