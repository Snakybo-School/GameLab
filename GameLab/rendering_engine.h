#pragma once

#include "camera.h"

class GameObject;

class RenderingEngine {
public:
	RenderingEngine();
	virtual ~RenderingEngine();

	void Render(GameObject* gameObject);

	inline void SetMainCamera(Camera* camera) { m_mainCamera = camera; }

	inline Camera& GetMainCamera() { return *m_mainCamera; }
protected:
private:
	RenderingEngine(const RenderingEngine& other) {}
	void operator=(const RenderingEngine& other) {}

	Camera* m_mainCamera;
};