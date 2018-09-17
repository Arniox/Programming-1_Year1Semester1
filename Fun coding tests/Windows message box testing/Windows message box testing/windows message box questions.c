#define _CRT_SECURE_NO_WARNINGS
#include <Windows.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int WINAPI WinMain(HINSTANCE hAPP, HINSTANCE HOldApp, LPSTR lpCmdLine, int CmdShow)
{
	int first_user_answer;
	int second_user_answer;
	int third_user_answer;

	first_user_answer = MessageBox(NULL, L"Did you achieve at least 80% lab tutorial attendance?", L"First Question", MB_YESNOCANCEL);
	if (first_user_answer != IDCANCEL)
	{
		second_user_answer = MessageBox(NULL, L"Did you achive a minimum of 40% in the Final Practical Exam?", L"Second Question", MB_YESNOCANCEL);
		if (second_user_answer != IDCANCEL)
		{
			third_user_answer = MessageBox(NULL, L"Did you achice a minimum of a C- grade overall?", L"Third question", MB_YESNOCANCEL);
		}
	}

	switch(first_user_answer)
	{
	case IDYES:
		{
			switch (second_user_answer)
			{
			case IDYES:
				{
					switch (third_user_answer)
					{
					case IDYES:
						{
							MessageBox(NULL, L"Congradulations, you will pass COMP500/ENSE501", L"Final message", MB_OK);
						}
						break;
					case IDNO:
						{
							MessageBox(NULL, L"Oh no, you will fail COMP500/ENSE501", L"Final message", MB_OK);
						}
						break;
					}
				}
				break;
			case IDNO:
				{
					MessageBox(NULL, L"Oh no, you will fail COMP500/ENSE501", L"Final message", MB_OK);
				}
				break;
			case IDCANCEL:
				{
					break;
				}
			}
		}
		break;
	case IDNO:
		{
			MessageBox(NULL, L"Oh no, you will fail COMP500/ENSE501", L"Final message", MB_OK);
		}
	case IDCANCEL:
		{
			break;
		}
	}
}

