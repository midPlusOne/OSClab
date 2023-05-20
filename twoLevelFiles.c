// TWO LEVEL DIRECTORY ORGANIZATION

#include <stdio.h>
#include <string.h>

struct
{
    char dname[10];
    char fname[10][10];
    int fileCount;

} dir[10];

int SearchDir(char dirName[10], int dirCount)
{
    /* if Dir found return pos, otherwise return -1 */
    int i;
    for (i = 0; i < dirCount; i++)
    {
        if (strcmp(dirName, dir[i].dname) == 0)
        {
            return i;
        }
    }

    return -1;
}

int SearchFile(char fileName[10], int pos)
{
    /* if file found return position, otherwise return -1 */
    int i;
    for (i = 0; i < dir[pos].fileCount; i++)
    {
        if (strcmp(fileName, dir[pos].fname[i]) == 0)
        {
            return i;
        }
    }

    return -1;
}

void main()
{
    int i, j, ch;
    int dirCount, flag, pos;
    char fileName[30], dirName[30];

    dirCount = 0;

    do
    {
        printf("\n\n1. Create Directory\t2. Create File\t3. Delete File");
        printf("\n4. Search File\t\t5. Display\t6. Exit");
        printf("\nEnter your choice: ");
        scanf("%d", &ch);

        switch (ch)
        {

        case 1:
            printf("\nEnter name of directory: ");
            scanf("%s", dirName);

            pos = SearchDir(dirName, dirCount);

            if (pos != -1) // flag == -1 means directory already exist
            {
                printf("\nDirectory %s already exist. Enter other names", dirName);
                break;
            }

            strcpy(dir[dirCount].dname, dirName);
            dir[dirCount].fileCount = 0;
            dirCount++;

            printf("\nDirectory created");
            break;

        case 2: // create files
            printf("\nEnter name of the directory: ");
            scanf("%s", dirName);

            pos = SearchDir(dirName, dirCount);

            if (pos == -1)
            {
                printf("\nDirectory %s not found\n", dirName);
                break;
            }

            printf("\nEnter name of the file: ");
            scanf("%s", fileName);

            flag = SearchFile(fileName, pos);

            if (flag != -1) // flag != -1 means file already exist
            {
                printf("File %s already exist", fileName);
                break;
            }

            strcpy(dir[pos].fname[dir[pos].fileCount], fileName);

            dir[pos].fileCount++;
            printf("\nFile created");

            break;

        case 3: // Delete Files

            printf("\nEnter name of the directory: ");
            scanf("%s", dirName);

            pos = SearchDir(dirName, dirCount);

            if (pos == -1)
            {
                printf("\nDirectory %s not found\n", dirName);
                break;
            }

            printf("Enter name of the file: ");
            scanf("%s", fileName);

            flag = SearchFile(fileName, pos);

            if (flag == -1)
            {
                printf("File %s not found", fileName);
                break;
            }

            i = flag;           // flag has file position

            printf("File %s is deleted ", fileName);
            dir[pos].fileCount--;
            strcpy(dir[pos].fname[i], dir[pos].fname[dir[pos].fileCount]);

            break;

        case 4: // search file
            printf("\nEnter name of the directory: ");
            scanf("%s", dirName);

            pos = SearchDir(dirName, dirCount);

            if (pos == -1)
            {
                printf("\nDirectory %s not found\n", dirName);
                break;
            }

            printf("Enter name of the file: ");
            scanf("%s", fileName);

            flag = SearchFile(fileName, pos);


            if (flag == -1)
                printf("File %s not found", fileName);

            else
                printf("File %s is found ", fileName);

            break;

        case 5:

            if (dirCount == 0)
            {
                printf("\nNo Directory's found.");
                break;
            }

            printf("\nDirectory \tFiles");

            for (i = 0; i < dirCount; i++)
            {
                printf("\n%s\t", dir[i].dname);

                for (j = 0; j < dir[i].fileCount; j++)
                    printf("\t%s", dir[i].fname[j]);
            }

            break;

        case 6:
            printf("\n\nExiting...\n\n");
            break;

        default:
            printf("Enter a valid choice!");
        }

    } while (ch != 6);
}
