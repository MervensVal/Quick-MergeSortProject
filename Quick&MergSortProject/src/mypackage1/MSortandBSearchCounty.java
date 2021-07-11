package mypackage1;

public class MSortandBSearchCounty {
	private County[] theArray; // ref to array theArray
	private int nElems; // number of data items
	// -----------------------------------------------------------

	public MSortandBSearchCounty(int max) // constructor
	{
	theArray = new County[max]; // create array
	nElems = 0;
	}

	// -----------------------------------------------------------
	public void insert(County value) // put element into array
	{
		theArray[nElems] = value; // insert it
		nElems++; // increment size
	}

	// -----------------------------------------------------------
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

	// -----------------------------------------------------------
	public void mergeSort() // called by main()
	{ // provides workspace
		County[] workSpace = new County[nElems];
		recMergeSort(workSpace, 0, nElems - 1);
	}

	// -----------------------------------------------------------
	private void recMergeSort(County[] workSpace, int lowerBound,
	int upperBound)
	{
	if(lowerBound == upperBound) // if range is 1,
	return; // no use sorting
	else
	{ // find midpoint
	int mid = (lowerBound+upperBound) / 2;
	// sort low half
	recMergeSort(workSpace, lowerBound, mid);
	// sort high half
	recMergeSort(workSpace, mid+1, upperBound);
	// merge them
	merge(workSpace, lowerBound, mid+1, upperBound);
	} // end else
	} // end recMergeSort()
		// -----------------------------------------------------------

	private void merge(County[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0; // workspace index
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1; // # of items
		while (lowPtr <= mid && highPtr <= upperBound)//<
			if (theArray[lowPtr].getCountyName().compareTo(theArray[highPtr].getCountyName()) > 0)
				workSpace[j++] = theArray[lowPtr++];
			else
				workSpace[j++] = theArray[highPtr++];
		while (lowPtr <= mid)
			workSpace[j++] = theArray[lowPtr++];
		while (highPtr <= upperBound)
			workSpace[j++] = theArray[highPtr++];
		for (j = 0; j < n; j++)
			theArray[lowerBound + j] = workSpace[j];
	} // end merge()
	
	//------------------------------------------------------------------------
	//------------------------------------------------------------------------

		//A Recursive Binary Search
	
		public int find(String searchKey) {
			return recFind(searchKey, 0, nElems - 1);
		}
		
		//--------------------------------------------------------------------
		private int recFind(String searchKey, int lowerBound, int upperBound) {
			int curIn;
			curIn = (lowerBound + upperBound) / 2;
			if (theArray[curIn].getCountyName().equals(searchKey) )
				return curIn; // found it
			else if (lowerBound > upperBound)
				return nElems; // can’t find it
			else // divide range
			{
				if (theArray[curIn].getCountyName().compareTo(searchKey) < 0 ) // it’s in upper half
					return recFind(searchKey, curIn + 1, upperBound);
				else // it’s in lower half
					return recFind(searchKey, lowerBound, curIn - 1);
			} // end else divide range
		} // end recFind()
		
		public void displaySingleCounty() 
		{
			
			System.out.println("Country Name: ");
			System.out.println("Population 2015: ");
			System.out.println("Population 2016: ");
			System.out.println("Population 2017: ");
			System.out.println("Population 2018: ");
			System.out.println("Population 2019: ");
		}
		
		//A Binary Search with a loop Example
		/*public int find(long searchKey) {
			int lowerBound = 0;
			int upperBound = nElems - 1;
			int curIn;
			while (true) {
				curIn = (lowerBound + upperBound) / 2;
				if (a[curIn] == searchKey)
					return curIn; // found it
				else if (lowerBound > upperBound)
					return nElems; // can’t find it
				else // divide range
				{
					if (a[curIn] < searchKey)
						lowerBound = curIn + 1; // it’s in upper half
					else
						upperBound = curIn - 1; // it’s in lower half
				} // end else divide range
			} // end while
		} // end find()*/
}
