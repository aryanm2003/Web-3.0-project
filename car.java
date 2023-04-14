public class Car {
    // Attributes
     String make;
     String model;
     int year;
     int speed;
     int x;
     int y;
     int z;

    
    public Car(String make, String model, int year, int speed, int x, int y, int z) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = speed;
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public void accelerate(int speed_increment) {
        this.speed += speed_increment;
    }

    public void brake(int speed_decrement) {
        this.speed -= speed_decrement;
    }

    public void move(int a,int b) {
        this.z += (int) (Math.cos(Math.toRadians(a)) * this.speed); //Taking spherical coordinate system
        this.x += (int) (Math.sin(Math.toRadians(a)) * Math.cos(Math.toRadians(b)) * this.speed); 
        this.y += (int) (Math.sin(Math.toRadians(a)) * Math.sin(Math.toRadians(b)) * this.speed);
    }

    public boolean detect_collision(Car car2) {
        int distance = (int) Math.sqrt(Math.pow((this.x - car2.x), 2) + Math.pow((this.y - car2.y), 2)+Math.pow((this.z-car2.z),2));
        if (distance <= 5) { // Assuming collision if distance is less than or equal to 5 units
            return true;
        } else {
            return false;
        }
    }

    public double time_to_collision(Car car2) {
        double dis = Math.sqrt(Math.pow((this.x - car2.x), 2) + Math.pow((this.y - car2.y), 2) + Math.pow((this.z - car2.z),2));
        double rel = Math.abs(this.speed - car2.speed);
        double time = dis / rel;
        return time;
    }

    // Main method for testing
    public static void main(String[] args) {
        Car car1 = new Car("Honda", "City", 2016, 60, 0, 0, 0);
        Car car2 = new Car("Maruti", "Alto", 2007, 50, 50, 50,50);
        System.out.println("Initial Coordinates of Car1: " + car1.x + ", " + car1.y+" ,"+car1.z);
        System.out.println("Initial Coordinates of Car2: " + car2.x + ", " + car2.y+","+car2.z);
        car1.accelerate(20);
        car1.move(60,30);
        car2.move(30,60);
        System.out.println("New Coordinates of Car1: " + car1.x + ", " + car1.y+","+car1.z);
        System.out.println("New Coordinates of Car2: " + car2.x + ", " + car2.y+","+car2.z);
        System.out.println("Collision detected: " + car1.detect_collision(car2));
        System.out.println("Time to collision: " + car1.time_to_collision(car2) + " seconds");
    }
}
