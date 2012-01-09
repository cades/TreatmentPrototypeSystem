package storage;


public class Hospital {
	private InspectionPlaceStorage inspectionPlaces;
	private static Hospital _instance;
	protected Hospital() {
	    inspectionPlaces = new InspectionPlaceStorage();
	}
	public static Hospital Instance() {
	    if(_instance == null) _instance = new Hospital();
	    return _instance;
	}
	
	public InspectionPlaceStorage inspectionPlaces() { return inspectionPlaces; }
}
