import sys

if __name__ == '__main__':
	output_folder = sys.argv[1];
	input = ' '.join(f'{symbol}' for symbol in sys.argv[2])
	with open(output_folder, 'w') as file:
		file.write("int array[] = {{ {args[0]}, {args[1]}, {args[2]}, {args[3]}, {args[4]} }};".format(args = input.split()))