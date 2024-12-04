from cat import Cat
from dog import Dog
from shelter import Shelter


shelter = Shelter("Happy Tails")
dog = Dog("Buddy", 4, "Golden Retriever")
cat = Cat("Whiskers", 2, "Tabby")

# Add pets to the shelter
shelter.add_pet(dog)
shelter.add_pet(cat)

# Adopt a pet
shelter.adopt_pet("Buddy")  # Output: Buddy has been adopted from Happy Tails! Total adoptions: 1
shelter.list_pets()  # Whiskers should still be listed as available

# Return a pet to the shelter
shelter.return_pet("Buddy")
shelter.list_pets()  # Buddy is now available again

