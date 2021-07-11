package mypackage1;

public class QuicksortPop2018 {

	private County[] theArray; // ref to array theArray
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public QuicksortPop2018(int max) // constructor
		{
		theArray = new County[max]; // create the array
		nElems = 0; // no items yet
		}

	// --------------------------------------------------------------
	public void insert(County value) // put element into array
	{
		theArray[nElems] = value; // insert it
		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
		{
		
		System.out.printf("%-35s%-35s%-35s%-35s%-35s%-35s", "Country Name","Population 2015", "Population 2016", "Population 2017", "Population 2018", "Population 2019");
		System.out.println();
		
		for(int i = 0; i < 200; i++) {
			System.out.print("-");
		}
		
		System.out.println();
		
		for(int i = 0; i < nElems; i++) {
			System.out.printf(i + 1 + ". " +"%-35s%-35s%-35s%-35s%-35s%-35s",theArray[i].getCountyName(), theArray[i].getPopulation2015(), 
					theArray[i].getPopulation2016(), theArray[i].getPopulation2017(),
					theArray[i].getPopulation2018(), theArray[i].getPopulation2019());
					System.out.println();
		}
		System.out.println();
		}

	// --------------------------------------------------------------
	public void quickSort() {
		recQuickSort(0, nElems - 1);
	}

	// --------------------------------------------------------------
	public void recQuickSort(int left, int right) {
		if (right - left <= 0) // if size <= 1,
			return; // already sorted
		else // size is 2 or larger
		{
			int pivot = Integer.parseInt(theArray[right].getPopulation2018()); // rightmost item
			// partition range
			int partition = partitionIt(left, right, pivot);
			recQuickSort(left, partition - 1); // sort left side
			recQuickSort(partition + 1, right); // sort right side
		}
	} // end recQuickSort()
		// --------------------------------------------------------------

	public int partitionIt(int left, int right, int pivot) {
		int leftPtr = left - 1; // left (after ++)
		int rightPtr = right; // right-1 (after --)
		while (true) { // find bigger item
			while (Integer.parseInt(theArray[++leftPtr].getPopulation2018()) < pivot); // (nop)
					// find smaller item
			while (rightPtr > 0 && Integer.parseInt(theArray[--rightPtr].getPopulation2018()) > pivot); // (nop)
			if (leftPtr >= rightPtr) // if pointers cross,
				break; // partition done
			else // not crossed, so
				swap(leftPtr, rightPtr); // swap elements
		} // end while(true)
		swap(leftPtr, right); // restore pivot
		return leftPtr; // return pivot location
	} // end partitionIt()
		// --------------------------------------------------------------

	public void swap(int dex1, int dex2) // swap two elements
	{
		County temp = theArray[dex1]; // A into temp
		theArray[dex1] = theArray[dex2]; // B into A
		theArray[dex2] = temp; // temp into B
	} // end swap(
		// --------------------------------------------------------------
}
