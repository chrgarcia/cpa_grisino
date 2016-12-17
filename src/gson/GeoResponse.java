package gson;

import java.util.List;

public class GeoResponse {
    List<Result> results;
    String status;

    public static class Result {
        List<AddressComponent> address_components;
        String formatted_address;
        Geometry geometry;
        boolean partial_match;
        String place_id;
        List<String> types;

        static class AddressComponent {
            String long_name, short_name;
            List<String> types;
        }

        static class Geometry {
            Rect bounds;
            LatLng location;
            String location_type;
            Rect viewport;

            static class Rect {
                LatLng northeast, southwest;
            }

            static class LatLng {
                double lat, lng;
            }
        }

		public List<AddressComponent> getAddress_components() {
			return address_components;
		}

		public void setAddress_components(List<AddressComponent> address_components) {
			this.address_components = address_components;
		}

		public String getFormatted_address() {
			return formatted_address;
		}

		public void setFormatted_address(String formatted_address) {
			this.formatted_address = formatted_address;
		}

		public Geometry getGeometry() {
			return geometry;
		}

		public void setGeometry(Geometry geometry) {
			this.geometry = geometry;
		}

		public boolean isPartial_match() {
			return partial_match;
		}

		public void setPartial_match(boolean partial_match) {
			this.partial_match = partial_match;
		}

		public String getPlace_id() {
			return place_id;
		}

		public void setPlace_id(String place_id) {
			this.place_id = place_id;
		}

		public List<String> getTypes() {
			return types;
		}

		public void setTypes(List<String> types) {
			this.types = types;
		}
        
        
        
    }

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
    
}


