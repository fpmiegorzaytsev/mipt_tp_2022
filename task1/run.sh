#!/bin/bash


array=($1 $2 $3 $4 $5 $6 $7 $8)
for var in 0  2  4  6
do
if [ ${array[var]} = "--input_folder" ]; 
then input_folder=${array[var+1]}
elif [  ${array[var]} = "--backup_folder" ];
then backup_folder=${array[var+1]} 
elif [ ${array[var]} = "--extension" ];
then extension=${array[var+1]}
elif [ ${array[var]} = "--backup_archive_name" ];
then backup_archive_name=${array[var+1]}
fi
done
mkdir $backup_folder
cd $backup_folder
backup_folder_path=$(pwd)
files=$(find $input_folder -depth -name "*.$extension")
for file in $files
do
cp --backup=numbered $file $backup_folder_path
done
cd ..
tar -czf "$backup_archive_name" "$backup_folder"
echo done

