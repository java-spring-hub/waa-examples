package mum.edu.domain;

public class CellManagement {
 
       	int cellCounter = 0;
        int totalCells = 4;
 
        
        public CellManagement() {}
        
        public CellManagement(int totalCells) { this.totalCells=totalCells;}
        
  		public int getTotalCells() {
 			return totalCells;
 		}
 		 

 		 public int getCellCounter() {
			return cellCounter;
		}
		 
  		 public void  resetCellCounter() {
  			cellCounter = 0;
 			return ;
 		}
 		 
  		 public int  incrementCellCounter() {
 			return cellCounter++;
 		}
 		 
 		 public void setCellCounter(int cellCounter) {
 			this.cellCounter = cellCounter;
 		}
		

    }

