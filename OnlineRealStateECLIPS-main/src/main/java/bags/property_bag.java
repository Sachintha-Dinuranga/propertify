package bags;

public class property_bag {

    private String pname, name, ptype, psubtype,srproperty, contact, cityname, details, filename, path, pincode, bedroom, bathroom, area, areasq, address, location;
    private float price, minprice, maxprice;
    int status, id, pid;

    public property_bag() {
    }

    public property_bag(String pname, String name, String ptype, String psubtype, String srproperty, String contact, String cityname, String details, String filename, String path, String pincode, String bedroom, String bathroom, String area, String areasq, String address, String location, float price, float minprice, float maxprice, int status, int id) {
        this.pname = pname;
        this.name = name;
        this.ptype = ptype;
        this.psubtype = psubtype;
        this.srproperty = srproperty;
        this.contact = contact;
        this.cityname = cityname;
        this.details = details;
        this.filename = filename;
        this.path = path;
        this.pincode = pincode;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.area = area;
        this.areasq = areasq;
        this.price = price;
        this.minprice = minprice;
        this.maxprice = maxprice;
        this.status = status;
        this.id = id;
        this.address = address;
        this.location = location;
    }

    public float getMinprice() {
        return minprice;
    }

    public void setMinprice(float minprice) {
        this.minprice = minprice;
    }

    public float getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(float maxprice) {
        this.maxprice = maxprice;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPsubtype() {
        return psubtype;
    }

    public void setPsubtype(String psubtype) {
        this.psubtype = psubtype;
    }

    public String getSrproperty() {
        return srproperty;
    }

    public void setSrproperty(String srproperty) {
        this.srproperty = srproperty;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public String getAreasq() {
        return areasq;
    }

    public void setAreasq(String areasq) {
        this.areasq = areasq;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}
