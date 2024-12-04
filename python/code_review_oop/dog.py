from pet import Pet

class Dog(Pet):
    def __init__(self, name, age, breed) -> None:
        super().__init__(name, age, species="Dog")
        self.breed = breed
        
    def make_sound(self):
        """Dog-specific sound."""
        print(f"{self.name} says: Woof!")