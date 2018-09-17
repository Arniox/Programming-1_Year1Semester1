#include <Windows.h>
#include <lmcons.h>

LRESULT CALLBACK WndProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam) 
{
	switch (msg)											//message handling function. Takes in window handler, message function, and extra parameters
	{
			case WM_PAINT:									//WM_PAINT message handler
			{
				int x;		//sets two ints
				int y;
				PAINTSTRUCT ps;	//sets PAINTSTRUCT structure up
				HDC hdc = BeginPaint(hwnd, &ps);	//begins the paint for the windows handler with the paintstructure
				for (int k = 0; k < 5000; ++k)		//this will iterate from 0 to 5000
				{
					x = rand() % 640;				//sets a random number for x and y
					y = rand() % 480;
					SetPixel(hdc, x, y, RGB(0, 0, 255)); //sets a pixel at position x and y and sets it to blue.
				}
				for (int k = 0; k < 5000; ++k)		//ect....
				{
					x = rand() % 640;
					y = rand() % 480;
					SetPixel(hdc, x, y, RGB(0, 255, 0));
				}
				for (int k = 0; k < 5000; ++k)
				{
					x = rand() % 640;
					y = rand() % 480;
					SetPixel(hdc, x, y, RGB(255, 0, 0));
				}
				EndPaint(hwnd, &ps);
			}
			break;
		case WM_CLOSE:					//message handler for WM_CLOSE so when you close the window, it sends a message for destroy
			{
				DestroyWindow(hwnd);
			}
			break;
		case WM_DESTROY:				//message handler for the destroy message above, it quits the window
			{
				PostQuitMessage(0);
			}
			break;
		default:						//default message handler
			{
				return DefWindowProc(hwnd, msg, wParam, lParam);
			}
	}
	return 0;
}

int WINAPI WinMain(HINSTANCE hApp, HINSTANCE hOld, LPSTR parems, int nCmdShow)
{

	const wchar_t g_szClassName[] = L"exampleWindowClass";		//sets up window
	WNDCLASSEX wc;												//WINDCLASSEX structure
	ZeroMemory(&wc, sizeof(wc));								//zero memories the structure with the structure and the size of the structure
	wc.cbSize = sizeof(WNDCLASSEX);								//sets all the members with data
	wc.style = 0;
	wc.lpfnWndProc = WndProc;
	wc.cbClsExtra = 0;
	wc.cbWndExtra = 0;
	wc.hInstance = hApp;
	wc.hIcon = LoadIcon(NULL, IDI_APPLICATION);
	wc.hCursor = LoadCursor(NULL, IDC_ARROW);
	wc.hbrBackground = (HBRUSH)(COLOR_WINDOW + 1);
	wc.lpszMenuName = NULL;
	wc.lpszClassName = g_szClassName;
	wc.hIconSm = LoadIcon(NULL, IDI_APPLICATION);

	if (!RegisterClassEx(&wc))		//registers the class, if it fails, tell the user it did
	{
		MessageBox(0, L"Error Registering Window!", L"Error", MB_OK);
		return 0;
	}

	HWND hwnd = CreateWindowEx(WS_EX_CLIENTEDGE,		//creates window and saves it to window handle pointer
		g_szClassName,
		L"COMP500/ENSE501",
		WS_OVERLAPPEDWINDOW,
		CW_USEDEFAULT, CW_USEDEFAULT,
		640, 480,
		NULL, NULL, hApp, NULL);
	if (NULL == hwnd)	//if the window handler is NULL, then the window failed to create
	{
		MessageBox(0, L"Error Creating Window!", L"Error", MB_OK);
		return 0;
	}

	ShowWindow(hwnd, nCmdShow);	//show window function
	UpdateWindow(hwnd);			//this updates the window by sending WM_PAINT

	MSG message;
	while (GetMessage(&message, NULL, 0, 0) > 0)	//keeps looping to get new messages and update the messages
	{
		TranslateMessage(&message);					//translates messages
		DispatchMessage(&message);					//dispatches the messages to the message handler
	}
	return message.wParam;
}