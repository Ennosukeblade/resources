from pet import Pet

class Cat(Pet):
    def __init__(self, name, age, color) -> None:
        super().__init__(name, age, species="Cat")
        self.color = color

    def make_sound(self):
        """Cat-specific sound."""
        print(f"{self.name} says: Meow!")