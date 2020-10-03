// "static void main" must be defined in a public class.
public class AnimalShelter {
    
    enum ANIMAL_TYPE {
        CAT,
        DOG,
        MAX_ANIMAL
    };

    class Animal {
        public ANIMAL_TYPE mType;
        public long        mArrivalTime;

        Animal(ANIMAL_TYPE t, long time)
        {
            this.mType = t;
            this.mArrivalTime = time;
        }
    };
    
    LinkedList <Animal> DogQueue;
    LinkedList <Animal> CatQueue;
    
    void enqueue(Animal a)
    {
        switch (a.mType)
        {
            case CAT:
                CatQueue.add(a);
                break;
            case DOG:
                DogQueue.add(a);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
    
    Animal dequeueDog()
    {
        if (DogQueue.isEmpty())
        {
            System.out.println("Error");
            return null;
        }
        System.out.println("Dog:" + DogQueue.peek().mArrivalTime);
        return DogQueue.poll();
    }
    Animal dequeueCat()
    {
        if (CatQueue.isEmpty())
        {
            System.out.println("Error");
            return null;
        }
        System.out.println("Cat:" + CatQueue.peek().mArrivalTime);
        return CatQueue.poll();
    }
    Animal dequeueAny()
    {
        if (CatQueue.isEmpty())
            return dequeueDog();
        if (DogQueue.isEmpty())
            return dequeueCat();
        Animal oldestDog = DogQueue.peek();
        Animal oldestCat = CatQueue.peek();

        if (oldestDog.mArrivalTime < oldestCat.mArrivalTime)
        {
            return dequeueDog();
        }
        else
        {
            return dequeueCat();
        }
    }

    public void populate()
    {
        DogQueue = new LinkedList();
        CatQueue = new LinkedList();
        enqueue(new Animal(ANIMAL_TYPE.DOG, 1));
        enqueue(new Animal(ANIMAL_TYPE.DOG, 2));
        enqueue(new Animal(ANIMAL_TYPE.CAT, 3));
        enqueue(new Animal(ANIMAL_TYPE.CAT, 4));
        enqueue(new Animal(ANIMAL_TYPE.DOG, 5));
        enqueue(new Animal(ANIMAL_TYPE.CAT, 6));
        enqueue(new Animal(ANIMAL_TYPE.CAT, 7));
        enqueue(new Animal(ANIMAL_TYPE.DOG, 8));
        enqueue(new Animal(ANIMAL_TYPE.CAT, 9));
        enqueue(new Animal(ANIMAL_TYPE.CAT, 10));
        
        dequeueAny();
        dequeueAny();
        dequeueCat();
        dequeueAny();
        dequeueDog();
        dequeueAny();
        dequeueAny();
        dequeueDog();
        dequeueCat();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        AnimalShelter obj = new AnimalShelter();
        obj.populate();
    }
}