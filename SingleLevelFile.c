// SINGLE LEVEL DIRECTORY ORGANIZATION

#include <stdio.h>
#include <string.h>

struct
{
    char dname[10];
    char fname[10][10];
    int fileCount;

} dir;

int SearchFile(char fileName[10])
{
    /* if file found return position, otherwise return -1 */
    int i;
    for (i = 0; i < dir.fileCount; i++)
    {
        if (strcmp(fileName, dir.fname[i]) == 0)
        {
            return i;
            break;
        }
    }

    if (i == dir.fileCount)
        return -1;
}

void main()

{

    int i, ch, pos;
    char fileName[30];

    dir.fileCount = 0;

    printf("\nEnter name of directory: ");
    scanf("%s", dir.dname);

    do
    {
        printf("\n1. Create File\n2. Delete File\n3. Search File \n4. Display Files\n5. Exit");
        printf("\nEnter your choice: ");
        scanf("%d", &ch);

        switch (ch)
        {

        case 1:
            printf("\nEnter the name of the file: ");
            scanf("%s", dir.fname[dir.fileCount]);
            printf("File %s created!",dir.fname[dir.fileCount]);
            dir.fileCount++;
            break;

        case 2:

            printf("\nEnter the name of the file: ");
            scanf("%s", fileName);

            pos = SearchFile(fileName);

            if (pos == -1) // File not found
            {
                printf("File %s not found", fileName);
                break;
            }

            printf("File %s is deleted ", fileName);
            strcpy(dir.fname[pos], dir.fname[dir.fileCount - 1]);
            dir.fileCount--;

            break;

        case 3:
            printf("\nEnter the name of the file: ");
            scanf("%s", fileName);

            pos = SearchFile(fileName);

            if (pos == -1)
                printf("File %s not found", fileName);
            else
                printf("File %s is found ", fileName);

            break;

        case 4:

            if (dir.fileCount == 0)
            {
                printf("\nDirectory is Empty.\n");
                break;
            }

            printf("\nThe Directory %s has Files: \n ", dir.dname);
            for (i = 0; i < dir.fileCount; i++)
                printf("\t%s", dir.fname[i]);

            break;

        case 5:
            printf("\n\nExiting...\n\n");
            break;

        default:
            printf("Enter a valid choice!");
        }

    } while (ch != 5);
}
