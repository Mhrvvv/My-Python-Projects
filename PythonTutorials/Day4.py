#print in color
#Color Values:
#default = 0, black = 30, red = 31, green = 32, yellow = 33; blue = 34, purple = 35, cyan = 36, white = 37
#print("Uh, oh, you've been given a", "\033[31m", "warning", "\033[0m", "for being a bad, bad person.")
print("=== Your Adventure Simulator ===")
print("""You'll be asked a bunch of questions
then we'll make you up an amazing
story with YOU as the star! 🥳""")
print()
name = input("Your name: ")
enemy = input("Your worst enemy: ")
superPower = input("Your super power: ")
print()
print("Our story begins as our hero,\033[33m", name, "\033[0mapproaches a foreboding castle...")
print("Suddenly a bolt of lightning striked the ground at the feet of\033[33m", name, "\033[0m")
print("'Our final battle begins!' shouts the evil\033[31m", enemy, "\033[0mclearly missing the fact that\033[33m", name, "\033[0mhas the power of\033[34m", superPower, "\033[0mwhich means they'll win quite easily!")
